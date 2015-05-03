package com.apps.sideness.boobasoundboard;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sideness on 02/05/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Activity activity;

    public ImageAdapter(Activity activity) {
        this.activity = activity;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder
    {
        public ImageView imgViewFlag;
        public TextView txtViewTitle;
    }


    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        LayoutInflater li = activity.getLayoutInflater();
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);

                v = new ViewHolder();
                convertView = li.inflate(R.layout.image_adapter_layout, null);
                v.txtViewTitle = (TextView) convertView.findViewById(R.id.icon_text);
                v.imgViewFlag = (ImageView) convertView.findViewById(R.id.icon_image);

                convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }

        v.txtViewTitle.setText(mThumbTx[position]);
        v.imgViewFlag.setImageResource(mThumbIds[position]);
        return convertView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.im1, R.drawable.im2,
            R.drawable.im3, R.drawable.im4,
            R.drawable.im5, R.drawable.im6,
            R.drawable.im7, R.drawable.im8,
            R.drawable.im9, R.drawable.im10,
            R.drawable.im11, R.drawable.im12,
            R.drawable.im13, R.drawable.im14,
            R.drawable.im15, R.drawable.im16,
            R.drawable.im17, R.drawable.im18,
            R.drawable.im19, R.drawable.im20,
            R.drawable.im21, R.drawable.im22,
            R.drawable.im23, R.drawable.im24,
            R.drawable.im25, R.drawable.im26,
            R.drawable.im27, R.drawable.im28,
            R.drawable.im29, R.drawable.im30,
            R.drawable.im31, R.drawable.im32,
            R.drawable.im33, R.drawable.im34,
            R.drawable.im35, R.drawable.im36,
            R.drawable.im37, R.drawable.im38,
            R.drawable.im39, R.drawable.im40,
            R.drawable.im41, R.drawable.im42,
            R.drawable.im43, R.drawable.im44,
            R.drawable.im45, R.drawable.im46,
            R.drawable.im47, R.drawable.im48,
            R.drawable.im49, R.drawable.im50,
            R.drawable.im51, R.drawable.im52,
            R.drawable.im53, R.drawable.im54,
            R.drawable.im55, R.drawable.im56,
            R.drawable.im57, R.drawable.im58,
            R.drawable.im59, R.drawable.im60,
            R.drawable.im61, R.drawable.im62,
            R.drawable.im62, R.drawable.im64,
            R.drawable.im65, R.drawable.im66,
            R.drawable.im67, R.drawable.im68,
            R.drawable.im69, R.drawable.im70,
            R.drawable.im71, R.drawable.im72,
            R.drawable.im73, R.drawable.im74,
            R.drawable.im75
    };

    private String[] mThumbTx = {
            "Bienvenue à bord","99 galères",
            "B.A.B","Bah ouais Morray",
            "O.S.B.L.C","Popeye",
            "Izi Izi Izi","Christophe Colomb",
            "Je t'apprécie beaucoup","Customisée",
            "Caresse","Du, du, du biff",
            "Eau bénite","Ecran Plasma",
            "Ici c'est Paris","Liquide de refroidissement",
            "Lingerie","La chatte à ta mère",
            "Rocco","Ragnagna",
            "M'aimerais-tu encore ?","Garde la pêche",
            "Je ne vous aime pas non plus","Sans faire de tâche",
            "Matérialiste","Numéro 10",
            "#OKLM","Lâche ton number",
            "Oseille","Salami",
            "Si t'es sérieuse","Tu peux rester",
            "Steak-frites","Fourrure",
            "Eglise","Wesh",
            "Filet-o-fish","Chou-fleur",
            "Emile","Pas de fesses",
            "Tu veux détronner le duc ?","Tu veux du taf ?",
            "Uncle Ben's","Booba",
            "G.H.B","Bordel !",
            "A l'aise","Immobilier",
            "Connasses","Double Poney Swag",
            "Les hommes","Pain aux raisins",
            "Grosses Ye-cou","Petit massage",
            "Rien à damer","Mes baskets",
            "Bluetooth","Sel et poivre",
            "Vaisselle","Cul à l'air sur un hammac",
            "Ra-tata-tat","Dans mon bed",
            "Hôtel Ibis","Sopalin",
            "Le cul de ta soeur","Les chicots",
            "Bim Bam Boum","Bam Bilibam",
            "Bois de boulogne","Roque-quette",
            "Je me faisais sucer","On s'ennuie",
            "Salam RAP FR","Ton Phone-tel",
            "Détronner le tuc"
    };
}