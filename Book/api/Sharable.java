package org.unict.api;


import org.unict.exception.OvershareException;

public interface Sharable {
    int MAXSHARING=2;

    void share() throws OvershareException;
    void unshare();

    int getSharing();



}
