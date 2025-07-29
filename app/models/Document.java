package models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Document  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String title;
    public String content;
    public String username;

    public Document() {
    }

    public Document(Long id, String title, String content,String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
