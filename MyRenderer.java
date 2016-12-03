package //PUT YOUR PROJECT PACKAGE NAME HERE.


import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;

public class MyRenderer extends RajawaliCardboardRenderer {

    Sphere sphere;

    public MyRenderer(Context context) {
        super(context);
    }

    @Override
    protected void initScene() {

        Log.i("Scene","init");

        getCurrentCamera().setPosition(Vector3.ZERO);
        getCurrentCamera().setRotation(0, 0, 90);
        getCurrentCamera().setFieldOfView(75);

        createSphere();

    }

    private void createSphere(){

        Material material = new Material();
        material.setColor(0);

        try {
            material.addTexture(new Texture("panorama", R.drawable.pano1));
        } catch (ATexture.TextureException e) {
            Log.i("Sphere Material ERROR", e.toString());
            //throw new RuntimeException(e);
        }

        sphere = new Sphere(50, 64, 32);
        sphere.setScaleX(-1);
        sphere.setMaterial(material);
        getCurrentScene().addChild(sphere);

    }

    public void changePano(int panoToChange){
        Material material = new Material();
        material.setColor(0);

        Vibrator v = (Vibrator) this.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);

        try {
            material.addTexture(new Texture("photo", panoToChange));
        } catch (ATexture.TextureException e) {
            Log.i("Sphere Material ERROR",e.toString());
            //throw new RuntimeException(e);
        }
        sphere.setMaterial(material);
    }

}
