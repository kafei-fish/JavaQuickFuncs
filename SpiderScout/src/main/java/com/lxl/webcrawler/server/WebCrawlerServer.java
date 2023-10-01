package com.lxl.webcrawler.server;

import org.springframework.stereotype.Service;

/**
 * 需求分析 目前需要获取每天的百度新闻热搜 并推送到微信 每天的百度热搜发生变化就进行推送通知
 *
 * @author 李晓龙
 * @version 1.0
 * @description: 爬虫的一个小demo
 * @date 2023/9/9 22:26
 */
@Service
public class WebCrawlerServer {
    String key = "SCT222908TuUQ5ktUGU6fuE7hG2kuVHjyc";

//    public static void main(String[] args) throws Exception {
//        //  拿到百度热搜的url https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065
//        String resultHtml = HttpClientUtil.sendGet("https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065");
//
//        // 解析html
//
//        Document doc = Jsoup.parse(resultHtml);
//        List<News> list = new ArrayList<>();
//        Elements titles = doc.select(".c-single-text-ellipsis");
//        Elements imgs = doc.select(".category-wrap_iQLoo .index_1Ew5p").next("img");
//        //内容
//        Elements contents = doc.select(".hot-desc_1m_jR.large_nSuFU");
//        //推荐图
//        Elements urls = doc.select(".category-wrap_iQLoo a.img-wrapper_29V76");
//        // 热搜指数
//        Elements levels = doc.select(".hot-index_1Bl1a");
//        for (int i = 0; i < levels.size(); i++) {
//            News news = new News();
//            news.setTitle(titles.get(i).text().trim());
//            news.setImg(imgs.get(i).attr("src"));
//            news.setUrl(urls.get(i).attr("href"));
//            news.setContent(contents.get(i).text().replaceAll("查看更多>,", "").trim());
//            news.setLevel(levels.get(i).text().trim());
//            news.setTop(i + 1 + "");
//            list.add(news);
//        }
//        ObjectMapper om = new ObjectMapper();
//        System.out.println(om.writeValueAsString(list));
//
//    }

//    public List<News> getWebCrawler(String url) {
//        //  拿到百度热搜的url https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065
//        String resultHtml = HttpClientUtil.sendGet(url);
//
//        // 解析html
//
//        Document doc = Jsoup.parse(resultHtml);
//        List<News> list = new ArrayList<>();
//        Elements titles = doc.select(".c-single-text-ellipsis");
//        Elements imgs = doc.select(".category-wrap_iQLoo .index_1Ew5p").next("img");
//        //内容
//        Elements contents = doc.select(".hot-desc_1m_jR.large_nSuFU");
//        //推荐图
//        Elements urls = doc.select(".category-wrap_iQLoo a.img-wrapper_29V76");
//        // 热搜指数
//        Elements levels = doc.select(".hot-index_1Bl1a");
//        for (int i = 0; i < levels.size(); i++) {
//            News news = new News();
//            news.setTitle(titles.get(i).text().trim());
//            news.setImg(imgs.get(i).attr("src"));
//            news.setUrl(urls.get(i).attr("href"));
//            news.setContent(contents.get(i).text().replaceAll("查看更多>,", "").trim());
//            news.setLevel(levels.get(i).text().trim());
//            news.setTop(i + 1 + "");
//            list.add(news);
//        }
//
//        return list;
//    }

//    @Async
//    public void sendMsg(String url) {
//        try {
//            System.out.println("异步线程开始了" + Thread.currentThread());
//            // 获取最新的新闻
//            List<News> oledCrawler = getWebCrawler(url);
//            Integer newsSie = oledCrawler.size();
//            while (true) {
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                List<News> newCrawler = getWebCrawler(url);
//                // 创建用于存储变化的列表
//
//                List<News> addedNews = new ArrayList<>();
//                List<News> removedNews = new ArrayList<>();
//                // 作比较 热搜是否发生改变
//                // 规则1：新热搜 与旧热搜 内容相同  但是排名不相同 给出那些上升 那些下降
//                // 规则2：新热搜 与旧热搜 内容不同 给出变化 给出新增的热搜
//                // 规则3：新热搜 与旧热搜 只比较 前三名 如果前三名发生变化 就发送消息
//                Boolean isChange = false;
//                for (Integer i = 0; i < newsSie; i++) {
//                    News oldNews = oledCrawler.get(i);
//                    News newNews = newCrawler.get(i);
//                    if (!Objects.equals(oldNews.getTitle(), newNews.getTitle())) {
//                        // 标题不同，说明发生了变化
//                        removedNews.add(oldNews);
//                        addedNews.add(newNews);
//                        isChange = true;
//                    }
//                }
//                // 发生变化
//                ObjectMapper objectMapper = new ObjectMapper();
//                String removedNewsStr = "百度热搜榜发生变化,最新热搜榜如下：" + objectMapper.writeValueAsString(addedNews);
//                if (isChange) {
//                    // 发生变化 重新赋值
//                    oledCrawler = newCrawler;
//                    String sendUrl = buildSendUrl(key,"热搜榜变化", removedNewsStr);
//                    HttpClientUtil.sendGet(sendUrl);
//                    System.out.println(removedNewsStr);
//                } else {
//                    System.out.println("没有发生改变");
//                }
//            }
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private String buildSendUrl(String key, String title, String removedNewsStr) {
        return String.format("https://sctapi.ftqq.com/%s.send?title=%s&desp=%s", key, title, removedNewsStr);
    }



//    public static void main(String[] args) throws Exception {
//        WebCrawlerServer webCrawlerServer = new WebCrawlerServer();
//
//        webCrawlerServer.sendMsg("https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065");
//    }
}
