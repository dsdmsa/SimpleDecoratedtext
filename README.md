
<p align="center">
  <img src="https://s26.postimg.org/w8iw7zu21/simple_Logov2.jpg" alt="Simple Decorated Text" width="226">
  <br>
</p>

<p align="center">SimpleDecoratedText helps you create simple, beautiful, intelligent, responsive TextViews.</p>

<p align="center"><img src="https://s26.postimg.org/kurrj1u5l/Screenshot_2016_08_25_15_07_15.png" width=350></p>



Features
------------

* **Clean, intuitive design** — With SimpleTextView you can create beautiful text views for you application in a single view

* **Everything on a single TextView** — TextDecor class offers a lot of posibilities, adding simple decors to you text : bold, italic, superscript effects to add click listeners on selected texts, change colors, adding shadows and more

* **Out-of-the-box** If you need some specific decoration you can add you own by implementing the interface

* **Performant, smoothly scrolling fonts in lists** adding fonts to text in lists hav no in pact on you scroll performance



Getting started with SimpleDecoratedtext is super easy! Simply add the dependency to you project and follow the instructions below.

Getting Started with Slate
------------------------------

### Prerequisites

You're going to need:

 - **Gradle or maven** — Windows may work, but is unsupported.
 - **Android**

### Getting Set Up

1. Add the dependency to you project or visit [Bintray](https://bintray.com/dsdmsa/AndroidText/com.dsdmsa.text) for details
```groovy
       compile 'com.dsdmsa.text:text_decor_V01:0.0.3'
```
or
```xml
    <dependency>
        <groupId>com.dsdmsa.text</groupId>
        <artifactId>text_decor_V01</artifactId>
        <version>0.0.4</version>
        <type>pom</type>
    </dependency>
```
2. Add in your xml Prittytext instead of TextView
```xml
    <com.decorator.text.textdecor.PrettyText
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:layout_height="match_parent"
        android:id="@+id/textDecor"/>
```

3.  Add some decorations in your code 
```java
        TextDecor bold = new TextDecor.Builder()
                .decorate(TextDecor.BOLD)
                .build();
        TextDecor fontAndUndeline = new TextDecor.Builder()
                .decorate(TextDecor.font(this,"fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.UNDERLINE)
                .build();
        TextDecor roundRgadient = new TextDecor.Builder()
                .decorate(TextDecor.setRoundBackground(9,2,new LinearGradient(0,0,545,545,Color.CYAN,Color.BLUE, Shader.TileMode.CLAMP),Color.BLACK))
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
4.  Get the prittytext from xml :
```java
    prettyText = (PrettyText) findViewById(R.id.textDecor);
```

5.  And use the decorations with needed text: 
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

Custom decorations :
------------------------------

1.  For spans woth params use code like this :
```java
  public static Decoration decor(final int param){
        return new Decoration() {
            @Override
            public Object newDecorInstance() {
                return new CustomSpan(param);
            }
        };
    }
```
2. For simple constant spans :
```java
 public static final Decoration STRINKE = new Decoration() {
        @Override
        public Object newDecorInstance() {
            return new StrikethroughSpan();
        }
    };
```

Need Help? Found a bug?
--------------------

[Submit an issue](https://github.com/dsdmsa/SimpleDecoratedtext/issues) to the SimpleDecoratedText Github if you need any help. And, of course, feel free to submit pull requests with bug fixes or changes.
















