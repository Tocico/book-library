package Model;

import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 15:53
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public enum Category {
    LYRIK("Lyrik"),
    DRAMATIK("Dramatik"),
    SKÖNLITTERATUR("Skönlitteratur"),
    ROMANNER("Romanner"),
    NOVELL("Novell"),
    DECKARE("Deckare"),
    SCIENCE_FICTION("Science fiction"),
    FANTASY("Fantasy"),
    ESSÄER("Essäer");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
