-keepnames class com.danielaboros.androidapp.objects.SearchObject
-if class com.danielaboros.androidapp.objects.SearchObject
-keep class com.danielaboros.androidapp.objects.SearchObjectJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
