package com.swiftfingers.rabbitmqdemo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.jsonqueue.name}")
    private String jsonQueue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingkey.name}")
    private String routingKey;

    @Value("${rabbitmq.routing.json.name}")
    private String routingJsonKey;

    //rabbitmq queue to store string messages
    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }

    //rabbitmq queue to store json messages
    @Bean
    public Queue jsonQueue() {
        return new Queue(jsonQueue, false);
    }


    //rabbitmq exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }


    //Binding between exchange and string queue using routing key
    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    //Binding between exchange and json queue using routing key
    @Bean
    public Binding jsonBinding(Queue jsonQueue, Exchange exchange) {
        return BindingBuilder.bind(jsonQueue())
                .to(exchange())
                .with(routingJsonKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
