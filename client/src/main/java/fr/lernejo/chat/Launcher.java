package fr.lernejo.chat;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(context.getBean(ConnectionFactory.class));
        while(true){
            System.out.println("Input a message, we will sent it for you (q for quit)");

            String str = sc.nextLine();
            if(str.equals("q")){
                System.out.println("Bye !");
                return;
            }else{
                rabbitTemplate.convertAndSend("","chat_messages",str);
            }
        }
    }
}
