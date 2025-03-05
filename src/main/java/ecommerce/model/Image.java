package ecommerce.model;

public class Image {
    private Long id;
    private String tittle;
    private String alttext;
    private String url;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTittle(){
        return this.tittle;
    }

    public void setTittle(String tittle){
        this.tittle = tittle;
    }

    public String getAlttext(){
        return this.alttext;
    }

    public void setAlttext(String alttext){
        this.alttext = alttext;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", alttext='" + alttext + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
