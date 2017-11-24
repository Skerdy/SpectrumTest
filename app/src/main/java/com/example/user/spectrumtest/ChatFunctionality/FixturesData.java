package com.example.user.spectrumtest.ChatFunctionality;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by W2020 Android on 11/21/2017.
 */

abstract class FixturesData {

    static SecureRandom rnd = new SecureRandom();

    static ArrayList<String> avatars = new ArrayList<String>() {
        {
            add("https://scontent.fskg1-1.fna.fbcdn.net/v/t31.0-8/16797287_1214827481905370_1452615798237214871_o.jpg?oh=2e22233f0800605ed04d6ae0f2fa49d6&oe=5AA41B5F");
            add("https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/16681667_1378333725550492_7645852226125849371_n.jpg?oh=9c46457513d78ec4a9e89380872f6827&oe=5AA51006");
            add("https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/10258009_887102014687854_1551946744427834665_n.jpg?oh=c305811285ce35d72f5ea55c00306399&oe=5AA22850");
            add("https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/10653551_4807371799521_3073438902636464705_n.jpg?oh=fd4ea1e36fd9e0f80205cbb3cf714f67&oe=5AA537B0");
        }
    };

    static final ArrayList<String> groupChatImages = new ArrayList<String>() {
        {
            add("https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p50x50/10258009_887102014687854_1551946744427834665_n.jpg?oh=4e43cb7d49703f461702afe4db53dc7a&oe=5AA031C1");
        }
    };

    static final ArrayList<String> groupChatTitles = new ArrayList<String>() {
        {
            add("Besnik, Artion, Skerdjan, Ersi");
        }
    };

    static final ArrayList<String> names = new ArrayList<String>() {
        {
            add("Artion Hasani");
            add("Skerdjan Gurabardhi");
            add("Besnik Palluqi");
            add("Ersi Musta");
        }
    };

    static final ArrayList<String> messages = new ArrayList<String>() {
        {
            add("Pershendetje");
            add("Yo!");
            add("K");
            add("Gha");
            add("Lul");
            add("Zero!");
            add("Yo");
            add("Yo");
            add("Yo!");
            add("Yup");
            add(":D");
        }
    };

    static final ArrayList<String> images = new ArrayList<String>() {
        {
            add("https://habrastorage.org/getpro/habr/post_images/e4b/067/b17/e4b067b17a3e414083f7420351db272b.jpg");
            add("http://www.designboom.com/wp-content/uploads/2015/11/stefano-boeri-architetti-vertical-forest-residential-tower-lausanne-switzerland-designboom-01.jpg");
        }
    };

    static String getRandomId() {
        return Long.toString(UUID.randomUUID().getLeastSignificantBits());
    }

    static String getRandomAvatar() {
        return avatars.get(rnd.nextInt(avatars.size()));
    }

    static String getRandomGroupChatImage() {
        return groupChatImages.get(rnd.nextInt(groupChatImages.size()));
    }

    static String getRandomGroupChatTitle() {
        return groupChatTitles.get(rnd.nextInt(groupChatTitles.size()));
    }

    static String getRandomName() {
        return names.get(rnd.nextInt(names.size()));
    }

    static String getRandomMessage() {
        return messages.get(rnd.nextInt(messages.size()));
    }

    static String getRandomImage() {
        return images.get(rnd.nextInt(images.size()));
    }

    static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }
}
