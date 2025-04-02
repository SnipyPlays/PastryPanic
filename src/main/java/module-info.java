module pastryPanic {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;

    exports com.github.hanyaeger.pastrypanic;

    opens audio;
    opens backgrounds;
    opens items;
    opens fonts;
    opens stations;
}
