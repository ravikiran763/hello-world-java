import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@EnableAutoConfiguration
public class HelloWorldApplication {


    public static void main(String[] args) throws Exception {
       System.out.println("Hello World");
       System.out.println("--------------");
    }

}
