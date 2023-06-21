public interface get_word {
    @GET("https://api.dictionaryapi.dev/api/v2/entries/en/hello")
    Call<String> message();

}
