# Simple TextView Decorations

##### This library is designed to help design complex text views in easy way

###### using a simple PrettyText in xml cam help you design complex textview, example in the image below :

![alt tag](https://s26.postimg.org/4j98g8bmx/screenshot.jpg)

### Example of use :
- ##### add in you xml Prittytext instead of TextView
```xml
    <com.decorator.text.textdecor.PrettyText
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:layout_height="match_parent"
        android:id="@+id/textDecor"/>
```
- ##### in you code create some decoration :
```java
 TextDecor power = new TextDecor.Builder()
                .decorate(DecorText.SUPERSCRIPT)
                .decorate(DecorSize.absoluteTextSize(25))
                .build();

        TextDecor robofont = new TextDecor.Builder()
                .decorate(DecorFonts.font(this, "fonts/Roboto-Thin.ttf"))
                .build();

        TextDecor withFont = new TextDecor.Builder()
                .decorate(DecorFonts.font(this, "fonts/doridrobot.ttf"))
                .decorate(DecorSize.absoluteTextSize(100))
                .build();

        TextDecor blueBack = new TextDecor.Builder()
                .decorate(DecorColor.setBackground(Color.BLUE))
                .decorate(DecorColor.setTextColor(Color.GREEN))
                .build();

        TextDecor textMod = new TextDecor.Builder()
                .decorate(DecorText.ITALIC)
                .decorate(DecorText.UNDERLINE)
                .build();
```
- ##### get the prittytext from xml :
```java
    prettyText = (PrettyText) findViewById(R.id.textDecor);
```

- ##### set the text : 
```java
     prettyText.setText(
                "this is a simple text, with no decorations\n",
                blueBack.withText("this text is with blue backgrownd\n"),
                robofont.withText("fonts are cool to add\n"),
                textMod.withText("italic and underline easy way\n"),
                withFont.withText("ecuations :\n"),
                " 3 * 3 = 9"," or 3",power.withText("2")
        );
```

- ##### To setUp the librarry add in you build.gradle the folowing depencence
```groovy
        compile 'com.dsdmsa.text:text_decor_V01:0.0.2'
```
- #### Visit [bintray link](https://bintray.com/dsdmsa/AndroidText/com.dsdmsa.text) for details

## Custom decorations :
- #### You can create you own decoratiuons
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




