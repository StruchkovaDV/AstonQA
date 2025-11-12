import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResponsePojo {

    private Map<String, String> args;
    private String data;
    private Map<String, String> files;
    private Map<String, String> form;
    private Map<String, String> headers;
    private String json;
    private String url;

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, String> getFiles() {
        return files;
    }

    public void setFiles(Map<String, String> files) {
        this.files = files;
    }

    public Map<String, String> getForm() {
        return form;
    }

    public void setForm(Map<String, String> form) {
        this.form = form;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String  getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponsePojo that)) return false;
        return Objects.equals(args, that.args)
                && Objects.equals(data, that.data)
                && Objects.equals(files, that.files)
                && Objects.equals(form, that.form)
                && Objects.equals(headers, that.headers)
                && Objects.equals(json, that.json)
                && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(args, data, files, form, headers, json, url);
    }
}
