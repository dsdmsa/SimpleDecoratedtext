# Simple TextView Decorations

##### This library is designed to help design complex text views in easy way

###### using a simple PrettyText in xml cam help you design complex textview, example in the image below :
 
![alt tag](https://s26.postimg.org/kurrj1u5l/Screenshot_2016_08_25_15_07_15.png)

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
 
        TextDecor bold = new TextDecor.Builder()
                .decorate(TextDecor.BOLD)
                .build();
        TextDecor fontAndUndeline = new TextDecor.Builder()
                .decorate(TextDecor.font(this,"fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.UNDERLINE)
                .build();
        TextDecor roundRgadient = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(9,2, new LinearGradient(0,0,545,545,Color.CYAN,Color.BLUE, Shader.TileMode.CLAMP),Color.BLACK))
                .decorate(TextDecor.BOLD)
                .build();
        TextDecor redBack = new TextDecor.Builder()
                .decorate(TextDecor.BOLD)
                .decorate(TextDecor.setTextColor(Color.RED))
                .decorate(TextDecor.setBackground(Color.BLACK))
                .decorate(TextDecor.absoluteTextSize(50))
                .build();

        TextDecor shadowCol = new TextDecor.Builder()
                .decorate(TextDecor.addShadow(2,2,5,Color.BLACK))
                .decorate(TextDecor.absoluteTextSize(40))
                .build();
 
```
-  get the prittytext from xml :
```java
    prettyText = (PrettyText) findViewById(R.id.textDecor);
```

-  set the text : 
```java
   prettyText.setText(
                roundRgadient.withText("Lorem Ipsum"),
                fontAndUndeline.withText(" is simply dummy text"),
                " of the printing and typesetting industry.",
                roundRgadient.withText(" Lorem Ipsum "),
                "has been the industry's standard dummy text ever since the ",
                redBack.withText("1500s"),
                shadowCol.withText(", when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the "),
                redBack.withText("1960s"),
                " with the release of ",
                bold.withText("Letraset"),
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of ",
                roundRgadient.withText("Lorem Ipsum")
        );
```

- To setUp the librarry add in you build.gradle the folowing depencence
```groovy
       compile 'com.dsdmsa.text:text_decor_V01:0.0.3'
```
- Visit [Bintray](https://bintray.com/dsdmsa/AndroidText/com.dsdmsa.text) for details

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




