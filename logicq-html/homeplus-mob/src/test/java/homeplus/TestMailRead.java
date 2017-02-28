package homeplus;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import com.logicq.homeplus.helper.PropertyHelper;

public class TestMailRead {
	
	public static void main(String[] args) {
		try {
		Properties props=PropertyHelper.loadMailProperty();
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("smtp.gmail.com", "homeplusservicebls@gmail.com","Homeplusservice@123");
		 Folder inbox = store.getFolder("inbox");
         inbox.open(Folder.READ_ONLY);
         int messageCount = inbox.getMessageCount();
         System.out.println("Total Messages:- " + messageCount);
         Message[] messages = inbox.getMessages();
         System.out.println("------------------------------");
         for (int i = 0; i < 10; i++) {
             System.out.println("Mail Subject:- " + messages[i].getSubject());
         }
         inbox.close(true);
         store.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
