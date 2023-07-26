package com.home.model;

public abstract class Entity <K> {
    private K id;

    public Entity (K id){
        this.id = id;
    }
    public Entity (){}

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public int hashCode(){
        int a = 7;
        a = 7 * a + id.hashCode();
        return a;
    }
    public boolean equals(Object o){
        if(o == this){
            return true;
        }if(o == null){
            return false;
        }if(o.getClass() != this.getClass()){
            return false;
        }
        return this.id.equals(((Entity<?>) o).id);
    }


}
