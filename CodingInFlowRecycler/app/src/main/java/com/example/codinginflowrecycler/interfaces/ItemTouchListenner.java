package com.example.codinginflowrecycler.interfaces;

public interface ItemTouchListenner {

    void onMove(int oldPosition, int newPosition);

    void swipe(int position, int direction);
}
