package com.example.user.spectrumtest.ChatFunctionality;

import com.example.user.spectrumtest.ChatFunctionality.Modelet.Dialog;
import com.example.user.spectrumtest.ChatFunctionality.Modelet.Message;
import com.example.user.spectrumtest.ChatFunctionality.Modelet.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by W2020 Android on 11/21/2017.
 */

public final class DialogsFixtures extends FixturesData {
    private DialogsFixtures() {
        throw new AssertionError();
    }

    public static ArrayList<Dialog> getDialogs() {
        ArrayList<Dialog> chats = new ArrayList<>();

        for (int i = 0; i <8; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -(i * i));
            calendar.add(Calendar.MINUTE, -(i * i));

            chats.add(getDialog(i, calendar.getTime()));
        }

        return chats;
    }

    private static Dialog getDialog(int i, Date lastMessageCreatedAt) {
        ArrayList<User> users = getUsers();
        return new Dialog(
                getRandomId(),
                users.size() > 1 ? groupChatTitles.get(0) : users.get(0).getName(),
                users.size() > 1 ? groupChatImages.get(0) : getRandomAvatar(),
                users,
                getMessage(lastMessageCreatedAt),
                i < 3 ? 3 - i : 0);
    }

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        int usersCount = 1 + rnd.nextInt(3);

        for (int i = 0; i < usersCount; i++) {
            users.add(getUser());
        }

        return users;
    }

    private static User getUser() {
        return new User(
                getRandomId(),
                getRandomName(),
                getRandomAvatar(),
                getRandomBoolean());
    }

    private static Message getMessage(final Date date) {
        return new Message(
                getRandomId(),
                getUser(),
                getRandomMessage(),
                date);
    }
}
