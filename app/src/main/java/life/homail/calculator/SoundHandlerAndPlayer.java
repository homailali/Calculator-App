package life.homail.calculator;
import android.media.MediaPlayer;
public class SoundHandlerAndPlayer {
    // Fields
    private CalculatorMain calculatorMain;
    private boolean ifAllowedToPlaySound=true;
    private MediaPlayer mediaPlayer;
    // Constructor
    public SoundHandlerAndPlayer(CalculatorMain calculatorMain) {
        this.calculatorMain = calculatorMain;
    }
    // Methods
    protected final void turnTheSoundOnOrOff(){
        if (this.ifAllowedToPlaySound){
            this.calculatorMain.calculatorViews.soundOnOffBtn.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.sound_off,0,0);
            this.ifAllowedToPlaySound=false;
        } else {
            this.calculatorMain.calculatorViews.soundOnOffBtn.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.sound_on,0,0);
            this.ifAllowedToPlaySound=true;
        }
    }
    protected final void playSound(){
        if (this.ifAllowedToPlaySound){
            this.mediaPlayer=MediaPlayer.create(this.calculatorMain,R.raw.btn_click_sound_light);
            this.mediaPlayer.start();
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }
}