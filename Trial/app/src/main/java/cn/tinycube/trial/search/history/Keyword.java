package cn.tinycube.trial.search.history;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午2:47.
 * @email: wangjianbiao@qccr.com
 * @desc: 搜索关键字
 */
public class Keyword implements Parcelable {

    private String keyword;

    private int type;

    private long timestamp;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    protected Keyword(Parcel in) {
        keyword = in.readString();
        type = in.readInt();
        timestamp = in.readLong();
    }

    public Keyword() {
    }

    public Keyword(String keyword, int type) {
        this.keyword = keyword;
        this.type = type;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(keyword);
        dest.writeInt(type);
        dest.writeLong(timestamp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Keyword> CREATOR = new Creator<Keyword>() {
        @Override
        public Keyword createFromParcel(Parcel in) {
            return new Keyword(in);
        }

        @Override
        public Keyword[] newArray(int size) {
            return new Keyword[size];
        }
    };

    @Override
    public String toString() {
        return "Keyword{" +
                "keyword='" + keyword + '\'' +
                ", type=" + type +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keyword _keyword = (Keyword) o;

        if (type != _keyword.type) return false;
        return keyword != null ? keyword.equals(_keyword.keyword) : _keyword.keyword == null;

    }

    @Override
    public int hashCode() {
        int result = keyword != null ? keyword.hashCode() : 0;
        result = 31 * result + type;
        return result;
    }
}
