package me.whiteship.demoredis;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("Mettings")
public class Meeting {


    private String id;

    private String title;

    private String startAt;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
