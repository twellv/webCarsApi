package ecommerce.model;

public class Image {

    // Img URL, Img ALT, Title
    private Long id;
    private String imgurl;
    private String imgalt;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgalt() {
        return imgalt;
    }

    public void setImgalt(String imgalt) {
        this.imgalt = imgalt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", imgalt='" + imgalt + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
