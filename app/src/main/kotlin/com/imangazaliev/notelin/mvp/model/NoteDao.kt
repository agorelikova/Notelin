package com.imangazaliev.notelin.mvp.model

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Callback
import java.util.*
import kotlin.reflect.KFunction1

class NoteDao {

//    @Inject
    var client: APIInterface = APIClient.getClient().create(APIInterface::class.java)

    fun createNote(): Observable<Note> {
        val note = Note("New note", Date())
        val result = client.create("123", note)
        return result.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun saveNote(note: Note): Observable<String> {
        println(note)
        return client.update("123", note.id, note)
                .map { res -> note.id }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadAllNotes(): Observable<MutableList<Note>> {
        return client.getAll("123")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getNoteById(noteId: String): Observable<Note> {
        return client.getById("123", noteId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun deleteAllNotes(): Observable<Boolean> {
        return client.removeAll("123")
                .map { res -> res.isSuccessful }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun deleteNote(note: Note): Observable<Boolean> {
        return client.remove("123", note.id)
                .map { res -> res.isSuccessful }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
