package com.decorator.text.textdecor;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.Shape;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.decorator.text.textdecor.custom_decors.ArrowBackgroundSpan;
import com.decorator.text.textdecor.custom_decors.BackgroundSpannable;
import com.decorator.text.textdecor.custom_decors.Click;
import com.decorator.text.textdecor.custom_decors.RoundedBackgroundSpan;
import com.decorator.text.textdecor.custom_decors.ShadowSpan;
import com.decorator.text.textdecor.custom_decors.ShapeBackgroundSpan;
import com.decorator.text.textdecor.custom_decors.TypefaceResourceSpan;
import com.decorator.text.textdecor.spans.Decoration;
import com.decorator.text.textdecor.utils.CustomTypefaceSpan;
import com.decorator.text.textdecor.utils.FontUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * with this class you can create text decoration rules that you can aplly to you text
 */
public class TextDecor {
    private String text;
    private List<String> strings = new ArrayList<>();
    private List<Decoration> characterStyles = new ArrayList<>();

    private TextDecor(Builder builder) {
        this.characterStyles = builder.decorations;
    }

    String getText() {
        text = strings.get(0);
        strings.remove(0);
        return text;
    }

    /**
     *  use this method to specify what text is using the text decor rule that you created
     * @param text
     * @return
     */
    public TextDecor withText(String text) {
        strings.add(text);
        return this;
    }

    void decorateText(SpannableString spannableString, int firstCharIndex, int lastCharIndex) {
        for (Decoration characterStyle : characterStyles) {
            spannableString.setSpan(characterStyle.newDecorInstance(), firstCharIndex, lastCharIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }

    /**
     * with this builder you start adding rules to you object
     */
    public static class Builder {
        private List<Decoration> decorations = new ArrayList<>();

        /**
         * add the rules to you rule class
         * @param decoration
         * @return
         */
        public Builder decorate(Decoration decoration) {
            decorations.add(decoration);
            return this;
        }

        /**
         * instantiate decor class eith rules
         * @return
         */
        public TextDecor build() {
            return new TextDecor(this);
        }
    }


    /**
     * decorations withowt parrams
     * Static final decorations
     */


    /**
     * adds underline to selected text
     */
    public static final Decoration UNDERLINE = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new UnderlineSpan();
        }
    };

    /**
     * strikes the sellected text
     */
    public static final Decoration STRINKE = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StrikethroughSpan();
        }
    };

    public static final Decoration SUBSCRIPT = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new SubscriptSpan();
        }
    };

    public static final Decoration SUPERSCRIPT = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new SuperscriptSpan();
        }
    };

    public static final Decoration BOLD = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.BOLD);
        }
    };

    public static final Decoration ITALIC = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.ITALIC);
        }
    };

    public static final Decoration ITALIC_BOLD = new Decoration() {
        @Override
        public CharacterStyle newDecorInstance() {
            return new StyleSpan(Typeface.BOLD_ITALIC);
        }
    };

    /**
     * decorations with parrams
     */

    public static Decoration setBlur(final int radius, final BlurMaskFilter.Blur style) {

        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new MaskFilterSpan(new BlurMaskFilter(radius, style));
            }
        };
    }

    public static Decoration absoluteTextSize(final int size){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new AbsoluteSizeSpan(size);
            }
        };
    }

    public  static Decoration relativeTextSize(final int size){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new AbsoluteSizeSpan(size);
            }
        };
    }

    public static Decoration font(final Context context, final String font){
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new CustomTypefaceSpan(font, FontUtil.get(context,font));
            }
        };
    }


    public static Decoration setTextColor(final int color) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new ForegroundColorSpan(color);
            }
        };
    }

    public static Decoration setBackground(final int color) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new BackgroundColorSpan(color);
            }
        };
    }


    /**
     * need improvment, not working correctly
     * better work allone
     * @param corner
     * @param padding
     * @param backgroundColor
     * @param textColor
     * @return
     */
    public static Decoration setRoundBackground(final int corner, final int padding, final int backgroundColor, final int textColor, final RoundedBackgroundSpan.Gravity gravity) {
        return new Decoration() {
            @Override
            public ReplacementSpan newDecorInstance() {
                return new RoundedBackgroundSpan(corner, padding, backgroundColor, textColor, gravity);
            }
        };
    }

    public static Decoration setRoundBackground(final int corner, final int padding, final int backgroundColor, final int textColor) {
        return new Decoration() {
            @Override
            public ReplacementSpan newDecorInstance() {
                return new RoundedBackgroundSpan(corner, padding, backgroundColor, textColor);
            }
        };
    }

    public static Decoration setRoundBackground(final int corner, final int padding, final LinearGradient backgroundColor, final int textColor) {
        return new Decoration() {
            @Override
            public ReplacementSpan newDecorInstance() {
                return new RoundedBackgroundSpan(corner, padding, backgroundColor, textColor);
            }
        };
    }

    public static Decoration addShadow(final float dx, final float dy, final float radius, final int color) {
        return new Decoration() {
            @Override
            public CharacterStyle newDecorInstance() {
                return new ShadowSpan(dx,dy,radius,color);
            }
        };
    }


    public static Decoration alignRight( ) {
        return new Decoration() {
            @Override
            public AlignmentSpan newDecorInstance() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE);
            }
        };
    }

    public static Decoration alignLeft( ) {
        return new Decoration() {
            @Override
            public AlignmentSpan newDecorInstance() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL);
            }
        };
    }

    public static Decoration alignCenter( ) {
        return new Decoration() {
            @Override
            public AlignmentSpan newDecorInstance() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
            }
        };
    }

    public static Decoration replaceTextWithImage(final Context context ,final int id,final int size) {
        return new Decoration() {
            @Override
            public ImageSpan newDecorInstance() {
                Drawable d = context.getResources().getDrawable(id);
                if (d != null) {
                    d.setBounds(0, 0, size, size);
                }
                return new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
            }
        };
    }

    public static Decoration clickableText(final Click click) {
        return new Decoration() {
            @Override
            public Click newDecorInstance() {
                return click;
            }
        };
    }

    public static Decoration test(final Click click) {
        return new Decoration() {
            @Override
            public Click newDecorInstance() {
                return click;
            }
        };
    }

}
