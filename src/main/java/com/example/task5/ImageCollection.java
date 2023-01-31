package com.example.task5;

import javafx.scene.image.Image;

public class ImageCollection implements Aggregate {

    private String picture;
    private Image bi;

    public ImageCollection(String picture) {
        this.picture = picture;
    }

    private class ImageIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            String filename = "picture"+(current+1)+".jpg";
            try {
                bi = new Image(filename);
                System.out.println(current);
                return true;
            } catch (Exception ex) {
                System.out.println(current=0);

                //system.err.println("Не удалось загрузить картинку " + filename);
                //ex.printStackTrace();
                return false;
            }
        }
        @Override
        public Object next() {
            if(this.hasNext()) {

                current++;
                return bi;

            }


            return null;
        }
        @Override
        public Object preview() {
            if(this.hasNext()) {
                current--;
                return bi;
            }
            return null;
        }
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}
