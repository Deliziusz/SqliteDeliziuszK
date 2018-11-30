package net.ivanvega.sqliteenandroid.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DAOUsuarios {

    private SQLiteDatabase _ad ;

    public DAOUsuarios(Context ctx) {
          _ad =
                  new MiAdaptadorUsuariosConexion(ctx).getWritableDatabase();
    }

    public long add(Usuario u)
    {

        ContentValues cv = new ContentValues();

        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[1], u.getNombre() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[2], u.getTelefono() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[3], u.getEmail());
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[4], u.getRed_social() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[5], u.getFechaNacimiento() );
        long result =_ad.insert(MiAdaptadorUsuariosConexion.TABLES_DB[0],null,cv);
        //_ad.close();
        return result;

    }

    public long   update (Usuario u){
        ContentValues cv = new ContentValues();
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[1], u.getNombre() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[2], u.getTelefono() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[3], u.getEmail());
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[4], u.getRed_social() );
        cv.put(MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS[5], u.getFechaNacimiento() );

        _ad.update(MiAdaptadorUsuariosConexion.TABLES_DB[0],
                cv,
                "_id=?",
                new String[]{String.valueOf( u.getId())}
                );
        //_ad.close();
        return 0;
    }

    public List<Usuario > getAll(){
        List <Usuario> lst = new ArrayList<Usuario>();
         Cursor c = _ad.query(
                MiAdaptadorUsuariosConexion.TABLES_DB[0],
                MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS,
                null, null,null,null,null
        );

         while(c.moveToNext()){

             lst.add(
               new Usuario(c.getInt(0), c.getString(1),
                       c.getString(2), c.getString(3),
                       c.getString(4),c.getString(5) )
             );

         }

        //_ad.close();
        return lst;
    }

    public Cursor getAllC(){
        Cursor c = _ad.query(
                MiAdaptadorUsuariosConexion.TABLES_DB[0],
                MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS,
                null, null,null,null,null
        );
        return c;
    }

  public Cursor getBusqueda(Usuario u){
        String whe="nombre='"+ u.getNombre()+"'";
        Cursor c = _ad.query(MiAdaptadorUsuariosConexion.TABLES_DB[0],
                MiAdaptadorUsuariosConexion.COLUMNS_USUARIOS,
                whe,
                null,
                null,
                null,
                null);
        //_ad.close();
        return c;
  }

  public Usuario buscar(int id){
       List<Usuario> todos = getAll();
      for (Usuario n:todos) {
          if (n.id == id){
              return n;
          }
      }
       return new Usuario(0,""+id,"","","");
    }

   public int getBorar(Usuario u){

        return _ad.delete(MiAdaptadorUsuariosConexion.TABLES_DB[0],"nombre='"+u.getNombre()+"'",null);
   }
}
