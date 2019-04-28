package com.ecust.test;

import com.ecust.utils.PageUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * 用来测试 Selenium
 */
public class TestSeleniumDemo {

    /**
     * 用来测试第一个代码，访问百度
     */
    @Test
    public void testHelloWordl() throws Exception {
        //开启个浏览器并且输入链接
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");
        //得到浏览器的标题
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        //关闭浏览器 下面是关闭所有标签页，还有一个代码是 driver.close();, 关闭当前标签页
        driver.quit();

    }






    /**
     * 测试向input标签输入值
     */
    @Test
    public void testInputStrByJS(){
        //开启个浏览器并且输入链接
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");
        //向input输入值
        PageUtils.inputStrByJS(driver, "kw", "月之暗面 博客园");
    }

    /**
     * 测试点击
     */
    @Test
    public void testScrollToElementAndClick() throws Exception {
        //1、开启个浏览器并且输入链接
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");

        //2、向百度输入框输入需要查询的值
        PageUtils.inputStrByJS(driver, "kw", "月之暗面 博客园");

        //3、得到百度一下的标签
        WebElement submitElement = driver.findElement(By.cssSelector("input#su"));

        //4、点击百度一下
        PageUtils.scrollToElementAndClick(submitElement, driver);

        //休息3秒，加载数据
        Thread.sleep(3000);

        //5、首先找到 id 为 content_left 的 div 下面的所有 div
        List<WebElement> divElements = driver.findElements(By.cssSelector("div#content_left div"));
        //6、找到搜索的第一个链接
        WebElement aElement = divElements.get(0).findElement(By.cssSelector("div.f13 a[href]"));

        //7、点击该链接
        PageUtils.scrollToElementAndClick(aElement, driver);
    }

    /**
     * 测试切换到另一个标签页
     */
    @Test
    public void testGetAnotherPage() throws Exception {
        //1、开启个浏览器并且输入链接
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");

        //2、向百度输入框输入需要查询的值
        PageUtils.inputStrByJS(driver, "kw", "月之暗面 博客园");

        //3、得到百度一下的标签
        WebElement submitElement = driver.findElement(By.cssSelector("input#su"));

        //4、点击百度一下
        PageUtils.scrollToElementAndClick(submitElement, driver);

        //休息3秒，加载数据
        Thread.sleep(3000);

        //5、首先找到 id 为 content_left 的 div 下面的所有 div
        List<WebElement> divElements = driver.findElements(By.cssSelector("div#content_left div"));
        //6、找到搜索的第一个链接
        WebElement aElement = divElements.get(0).findElement(By.cssSelector("div.f13 a[href]"));

        //7、点击该链接
        PageUtils.scrollToElementAndClick(aElement, driver);


        //8、当前页面是百度的页面
        System.out.println("现在的页面是："+driver.getTitle());
        //9、切换到博客园页面
        PageUtils.getAnotherPage(driver);
        System.out.println("现在的页面是："+driver.getTitle());
    }


    @Test
    public  void  to() throws Exception {
        //加载驱动器
      //  System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        //打开浏览器
        WebDriver driver = new ChromeDriver();
        //打开网站
        driver.get("https://www.baidu.com/");
        //通过id定位所搜框
        WebElement searchBox = driver.findElement(By.id("kw"));
        //输入内容
        searchBox.sendKeys("电影");
        //定位百度一下按钮
        WebElement searchButton = driver.findElement(By.id("su"));
        //点击百度一下
        searchButton.submit();
        //等待5s
        Thread.sleep(5000);
        //页面关闭
        driver.close();

        //打开浏览器
        WebDriver driver2 = new ChromeDriver();
        //打开网站
        driver2.get("https://www.douban.com/");
        //通过name定位所搜框
        WebElement searchBox2 = driver2.findElement(By.name("q"));
        //输入内容
        searchBox2.sendKeys("电影");
        //点击百度一下
        searchBox2.submit();
        //等待5s
        Thread.sleep(5000);
        //页面关闭
        driver2.close();
        //通过tagname查找元素
        //打开浏览器
        WebDriver driver3 = new ChromeDriver();
        //打开网站
        driver3.get("https://www.mi.com/");
        //通过tagname查找
        List<WebElement> scriptList = driver3.findElements(By.tagName("script"));
        //查找tagname为script的数量并输出
        System.out.println("there are "+scriptList.size()+" script");
        //等待5s
        Thread.sleep(5000);
        //页面关闭
        driver3.close();
    }

}