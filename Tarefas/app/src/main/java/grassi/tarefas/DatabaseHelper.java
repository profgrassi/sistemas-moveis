package grassi.tarefas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static int versaoDb = 1;
    private static String db = "tarefas_db";
    private static String nomeTabela = "tarefas";
    private static String coluna_id = "id";
    private static String coluna_tarefa = "data";

    public DatabaseHelper(Context context) {
        super(context, db, null, versaoDb);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + nomeTabela + "(" + coluna_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + coluna_tarefa + " TEXT"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + nomeTabela);
        onCreate(sqLiteDatabase);
    }

    public long novaTarefa(String tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(coluna_tarefa, tarefa);
        long id = db.insert(nomeTabela, null, cv);
        db.close();
        return id;
    }

    public int alterarTarefa(Tarefa tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(coluna_tarefa, tarefa.getTarefa());

        return db.update(nomeTabela, cv, "id" + " = ?",
                new String[]{String.valueOf(tarefa.getId())});
    }

    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT  * FROM " + nomeTabela;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(cursor.getInt(cursor.getColumnIndex(coluna_id)));
                tarefa.setTarefa(cursor.getString(cursor.getColumnIndex(coluna_tarefa)));
                tarefas.add(tarefa);
            } while (cursor.moveToNext());
        }
        db.close();
        return tarefas;
    }

    public void apagarTarefa(Tarefa tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(nomeTabela, coluna_id + " = ?",
                new String[]{String.valueOf(tarefa.getId())});
        db.close();
    }
}