-keepnames class com.danielaboros.androidapp.objects.MuseumObject
-if class com.danielaboros.androidapp.objects.MuseumObject
-keep class com.danielaboros.androidapp.objects.MuseumObjectJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
