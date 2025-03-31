module pastryPanic {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;

    exports com.github.hanyaeger.pastrypanic;

    opens audio;
    opens backgrounds;
    opens sprites;
    opens fonts;
    opens tilesets;
}
