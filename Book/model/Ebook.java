package org.unict.model;

import org.unict.api.Sharable;
import org.unict.exception.OvershareException;

public class Ebook extends Book implements Sharable {

    private int sharing;
    public Ebook(String title, String author, String isbn) {
        super(title, author, isbn);
        this.sharing = 0;
    }

    @Override
    public void share() throws OvershareException {
        if (this.sharing < MAXSHARING) {
            this.sharing++;
        } else {
            throw new OvershareException();
        }
    }

    @Override
    public void unshare() {
        if (this.sharing > 0) {
            this.sharing--;
        }
    }

    @Override
    public int getSharing() {
        return this.sharing;
    }
}
