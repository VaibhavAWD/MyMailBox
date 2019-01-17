package com.vaibhavdhunde.android.mymailbox.data;

import com.vaibhavdhunde.android.mymailbox.R;

import java.util.ArrayList;
import java.util.List;

public class EmailData {
    public static List<Integer> images = new ArrayList<Integer>() {{
        add(R.drawable.profile_image_1);
        add(R.drawable.profile_image_2);
        add(R.drawable.profile_image_3);
        add(R.drawable.profile_image_4);
        add(R.drawable.profile_image_5);
        add(R.drawable.profile_image_6);
        add(R.drawable.profile_image_7);
        add(R.drawable.profile_image_8);
        add(R.drawable.profile_image_9);
        add(R.drawable.profile_image_10);
        add(R.drawable.profile_image_11);
        add(R.drawable.profile_image_12);
    }};

    public static List<String> names = new ArrayList<String>() {{
        add("Ninja");
        add("Heidi");
        add("Dexter");
        add("Mel B");
        add("Alex");
        add("Natalia");
        add("Jerry");
        add("Max");
        add("Hazard");
        add("Maxwell");
        add("Amanda");
        add("Howie");
    }};

    public static List<String> dates = new ArrayList<String>() {{
        add("21/06/2018");
        add("16/06/2018");
        add("13/05/2018");
        add("4/05/2018");
        add("19/04/2018");
        add("11/04/2018");
        add("23/12/2017");
        add("17/11/2017");
        add("30/10/2017");
        add("12/09/2017");
        add("18/02/2016");
        add("9/01/2016");
    }};

    public static List<String> emails = new ArrayList<String>() {{
        add("ninja@gmail.com");
        add("heidi@gmail.com");
        add("dexter@gmail.com");
        add("melb@gmail.com");
        add("alex@gmail.com");
        add("natalia@gmail.com");
        add("jerry@gmail.com");
        add("max@gmail.com");
        add("hazard@gmail.com");
        add("maxwell@gmail.com");
        add("amanda@gmail.com");
        add("howie@gmail.com");
    }};

    public static List<String> subjects = new ArrayList<String>() {{
        add("Invitation for Mega GamePlay at PS2");
        add("Collected Business Analysis Details");
        add("Brand new Medicine invented");
        add("Musical Night in Vegas");
        add("Code Issue");
        add("Reports on Data Usage");
        add("Designs for your Banner");
        add("Tickets for Europe Tour");
        add("Board Meeting");
        add("List of Utilities");
        add("Fabulous upcoming Singing show");
        add("Issue resolved");
    }};

    public static List<Boolean> isBookmarked = new ArrayList<Boolean>() {{
        add(true);
        add(true);
        add(false);
        add(true);
        add(true);
        add(true);
        add(false);
        add(false);
        add(true);
        add(true);
        add(false);
        add(true);
    }};
}
