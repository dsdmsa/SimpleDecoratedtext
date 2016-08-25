# Simple TextView Decorations

##### This library is designed to help design complex text views in easy way

###### using a simple PrettyText in xml cam help you design complex textview, example in the image below :

![alt tag](https://s26.postimg.org/qk64abs2x/screenshot_1.jpg?2&j)

### Example of use :
-  add in your xml Prittytext instead of TextView
```xml
    <com.decorator.text.textdecor.PrettyText
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:layout_height="match_parent"
        android:id="@+id/textDecor"/>
```
- in you code create some decoration :
```java
 
         TextDecor rbackg = new TextDecor.Builder()
                .decorate(TextDecor.relativeTextSize(30))
                .decorate(TextDecor.BOLD)
                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.CENTER))
                .decorate(TextDecor.font(this, "fonts/Roboto-Thin.ttf"))
                .build();

        TextDecor siz = new TextDecor.Builder()
                .decorate(TextDecor.setTextColor(Color.WHITE))
                .decorate(TextDecor.absoluteTextSize(70))
                .decorate(TextDecor.setBackground(Color.RED))
                .decorate(TextDecor.UNDERLINE)
                .decorate(TextDecor.STRINKE)
                .decorate(TextDecor.BOLD)
                .build();

        TextDecor col = new TextDecor.Builder()
                .decorate(TextDecor.setBackground(Color.BLUE))
                .decorate(TextDecor.setTextColor(Color.WHITE))
                .build();

        TextDecor round = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK))
                .build();

        TextDecor round1 = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.BOTTOM))
                .build();

        TextDecor round2 = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(5, 11, Color.YELLOW, Color.BLACK, RoundedBackgroundSpan.Gravity.TOP))
                .build();
 
```
-  get the prittytext from xml :
```java
    prettyText = (PrettyText) findViewById(R.id.textDecor);
```

-  set the text : 
```java
     prettyText.setText(
                round.withText(" round "),
                siz.withText("\nYou pucharse\n"),
                rbackg.withText("Yesterday\n"),
                siz.withText("please show this QR......\n"),
                " simple text ",
                rbackg.withText("\n\nanother"),
                siz.withText(" siz\n"),
                col.withText(" col text \n")
        );
```

- To setUp the librarry add in you build.gradle the folowing depencence
```groovy
       compile 'com.dsdmsa.text:text_decor_V01:0.0.3'
```
- Visit [bintray link](https://bintray.com/dsdmsa/AndroidText/com.dsdmsa.text) for details

## Custom decorations :
-  You can create you own decoratiuons
1.  For spans woth params use code like this :
```java
  public static Decoration decor(final int param){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new CustomSpan(param);
            }
        };
    }
```
2. For simple constant spans :
```java
 public static final Decoration STRINKE = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StrikethroughSpan();
        }
    };
```




