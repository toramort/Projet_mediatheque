package database;

public class Evaluation {

    private int id_e;
    private String comment;
    private int note;
    private User user;

    public Evaluation(int id_e, String comment, int note, User user) {
        this.id_e = id_e;
        this.comment = comment;
        this.note = note;
        this.user = user;
    }

    public int getId_e() {
        return id_e;
    }

    public String getComment() {
        return comment;
    }

    public int getNote() {
        return note;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user + " : " + note;
    }
}
