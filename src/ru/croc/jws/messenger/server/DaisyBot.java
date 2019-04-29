package ru.croc.jws.messenger.server;

import ru.croc.jws.messenger.common.Message;
import ru.croc.jws.messenger.common.User;
import ru.croc.jws.messenger.game.MemAscII;
import ru.croc.jws.messenger.game.Weather;
import ru.croc.jws.messenger.game.Words;
import ru.croc.jws.messenger.game.Сities;

import java.util.Random;

public class DaisyBot implements Bot {
	Сities cities = new Сities();
	Words words = new Words();
	MemAscII memAscII = new MemAscII();

	private final User daisy = new User("bot");
	private final Random rnd = new Random(System.currentTimeMillis());

	@Override
	public User getUser() {
		return daisy;
	}

	@Override
	public void onMessage(Message message, MessageRepository messageRepository) {

		String text = "";
		String[] string = message.getText().split("\\s");

			if (message.getText().contains("help")||message.getText().contains("menu")||message.getText().contains("?")) {
				text = 	"\nMENU\n" +
                        " bot ? - список команд\n" +
                        "       Игры\n" +
						" bot cities(с) - играть в города\n"+
                        " bot mem rand - рандомный мем\n" +
                        "       Мемы\n" +
                        " bot mem list - список мемов\n" +
                        " bot mem \"memname\" - показать мем\n" +
                        "       Полезное\n" +
                        "bot weather  - погода в Москве\n";//TODO тк. нужно подключать библиотеки

			} else if (message.getText().contains("города") || message.getText().contains("cities")||string[1].equalsIgnoreCase("c")||string[1].equalsIgnoreCase("с")) {//Города
			    if(message.getText().contains("clear"))cities.clear();
				    else text = cities.getWord(string[2]);
				if (text == null) text = "Ты победил";

			}else if (message.getText().contains("слова") || message.getText().contains("words")||string[1].equalsIgnoreCase("w")) {//Слова
                if(message.getText().contains("clear"))words.clear();
                else text = words.getWord(string[2]);
                if (text == null) text = "Ты победил";}

			else if(message.getText().contains("mem")||message.getText().contains("мем")||string[1].equalsIgnoreCase("m")){//Мемы
			    if(message.getText().contains("list"))
			        for (int i = 0; i <memAscII.getFile().size() ; i++) text += " " + memAscII.getFile().get(i) + "\n";

			    else if(message.getText().contains("rand")){
			        String mem = memAscII.memRand();
			        text = memAscII.memView(mem);
                }
			    else text = memAscII.memView(string[2]);
            }
			else if ((message.getText().contains("weather"))){
			    Weather weather = new Weather();
			    text = "В москве " + weather.temp().get(0);
            }else
				text = "Я не знаю такой команды );";// не верная команда

		/*// imitate delay: do not reply instantly
		int delaySeconds = 1 + rnd.nextInt(3);
		try {
			Thread.sleep(delaySeconds * 1000);
		} catch (InterruptedException e) {
			return;
		}*/


		Message replyFromDaisy = new Message(
				daisy,
				Message.textWithMention(message.getUser(), "\n"+text));
		messageRepository.addMessage(replyFromDaisy);
	}

}
