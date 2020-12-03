package Model;

import java.util.ArrayList;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-01
 * Time: 12:10
 * Project: Bibliotek
 * Copyright: MIT
 */

     // Is this like a Map of shelf in the library?
    // Library(our teacher proposed this idea) or section class(Our idea :inside a library)

public class Section {
    protected int sectionID;
    protected ArrayList <String> sectionName=new ArrayList<String>(2); //A,B,C.... ()
    protected String shelfName; // for example (Tidningen, Magazin, Novel, Barnbok, Konst, Språk, Rekommendation)(ex:sectionA has two shelfName)


}
