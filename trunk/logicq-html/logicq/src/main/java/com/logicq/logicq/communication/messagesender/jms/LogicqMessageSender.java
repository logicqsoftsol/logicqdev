package com.logicq.logicq.communication.messagesender.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class LogicqMessageSender {
  
	private LogicqTemplate logicqTemplate;
    
    public void send(final String text) {
        
       /* this.logicqTemplate.send(new MessageCreator() {
          @Override
          public Message createMessage(Session session) throws JMSException {
            Message message = session.createTextMessage(text);     
            //set ReplyTo header of Message, pretty much like the concept of email.
            message.setJMSReplyTo(new ActiveMQQueue("LogicqSendToRecv"));
            return message;
          }
        });*/
      }
    /**
     * Simplify the send by using convertAndSend
     * @param text
     */
    public void sendText(final String text) {
     // this.logicqTemplate.convertAndSend(text);
    }
      
    /**
     * Send text message to a specified destination
     * @param text
     */
    public void send(final Destination dest,final String text) {
    /*    
      this.logicqTemplate.send(dest,new MessageCreator() {
        @Override
        public Message createMessage(Session session) throws JMSException {
          Message message = session.createTextMessage(text);
          return message;
        }
      });*/
    }
}
