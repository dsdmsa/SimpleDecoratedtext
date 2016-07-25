    Simple TextView Decorations

this library is designed to help design complex text views in easy way

using a simple PrettyText in xml cam help you design complex textview , example in image below

![alt tag](https://lh3.googleusercontent.com/OGU6TcnkCXf2wXam7yhxgOTXITUoK17wV02CHHlogn6gJ_WbOSvjJd984eIsZwtMFSt22liVOdemIq2hi2YL7dJ1xmoo4BrKyYzCCDTy_eD9CXAQZ0EKPNpKUBAy6to_MQmRlNaJOfTnLMSzwe-EIe8ZYlYY1wkmtEclp9kccn2ssOtjsvz2CxmjgzXrGqg5OW6T7NQHDTK_mbz59Vot5Tu6YP1cTrpbQcADY-kdk9xUgmIYRClLuXNp4XH46M2zk2opoV-WsVUG9cfl1QEtYaSlNS1hCIM5gcUWHafPIZ2Hy8dxQtT23Yg3vYrivgLN8KI-n8FKJDcKLUYUxFcXIpYJC14w4TwrT39NGmL7gNUobTi5KvmzLEDv7n76cMGprx5IT79UFOPFo8LIl_Vl4Ch3W16IiJh-NlERxVO5UCYL6Y53S4loTppeuxj3G30kfKCz7Ypwa0gYVFp8s1SMCV5lhHrZhE6PtMF_DvgoSoWhpU8lxL-k_ZcOnESCBUNqn83uVoul3pHDhKxpZv28lcwAp4w3bP2pk1nRWdq79Iw5FPZhQLozUnOMB_rpYBcbkVJDlNrn60CNM4-zGgpLHvDTKci8eFw=w533-h946-no)

Example of use :

add in you xml Prittytext instead of TextView

    <com.decorator.text.textdecor.PrettyText
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:layout_height="match_parent"
        android:id="@+id/textDecor"/>

in you code create some decoration :

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

get te prittytext reference :
    
    prettyText = (PrettyText) findViewById(R.id.textDecor);


and set the text : 

     prettyText.setText(
                "this is a simple text, with no decorations\n",
                blueBack.withText("this text is with blue backgrownd\n"),
                robofont.withText("fonts are cool to add\n"),
                textMod.withText("italic and underline easy way\n"),
                withFont.withText("ecuations :\n"),
                " 3 * 3 = 9"," or 3",power.withText("2")
        );


To setUp the librarry add in you build.gradle the folowing depencence

    compile 'com.dsdmsa.text:text_decor_V01:0.0.1'

and in build.gradle of the project add the following reposiroty :

    allprojects {
        repositories {
            jcenter()
            maven {
                url  "http://dl.bintray.com/dsdmsa/AndroidText"
            }
        }
    }






