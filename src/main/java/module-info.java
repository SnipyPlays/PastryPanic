module pastryPanic {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires jdk.xml.dom;

    exports com.github.hanyaeger.pastrypanic;

    opens audio;
    opens backgrounds;
    opens items;
    opens fonts;
    opens stations;
}
