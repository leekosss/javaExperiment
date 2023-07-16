package com.four;

public abstract class Decorator extends Component{
    public Component dc;
    public Decorator(){}
    public Decorator(Component dc) {
        this.dc = dc;
    }
}
