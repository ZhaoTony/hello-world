Building a RESTful Web Service
学习构建一个rest请求

代码：

    @RestController
    public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

RestController rest请求的辨识符号，一般在整个controller类的起始位置。
RequestMapping("/greeting")  将到"/greeting"的HTTP 请求映射到下面紧跟的Greet方案。
    RequestMapping(method=GET)表示这个映射是GET请求的映射。
RequestParam  将请求中的参数和方法中的参数映射。
main

* 不会使用web.xml文件

使用IDEA跑sprint-boot工程方法：
1. Run -> Edit Configurations...
2. 选择 Maven，创建一个Maven应用。 Command-line为spring-boot:run
