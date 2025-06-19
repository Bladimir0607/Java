import com.google.gson.annotations.SerializedName;

public record Pelicula(
    @SerializedName("title") String Title,
    @SerializedName("episode_id") int episode_id,
    @SerializedName("opening_crawl") String opening_crawl,
    @SerializedName("director") String director,
    @SerializedName("producer") String producer,
    @SerializedName("release_date") String release_date
) {}