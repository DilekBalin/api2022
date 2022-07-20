package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


public class GoRestResponseBodyPojo {
    private Object meta;// meta,nin karsisinda int,string olabilir o yuzden object dedik
    private GoRestDataPojo data;//bunun data tipi ==> GoRestDataPojo

    public GoRestResponseBodyPojo(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestResponseBodyPojo() {
    }




    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "GoRestResponseBodyPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
