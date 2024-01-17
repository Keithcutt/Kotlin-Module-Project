data class Archive (
    override val name: String,
    var listOfNotes: MutableList<DataContainer>,
): DataContainer {
    override fun toString(): String {
        return this.name
    }
}

data class Note(
    override val name: String,
    val text: String
): DataContainer {
    override fun toString(): String {
        return this.name
    }
}

object Exit: DataContainer {
    override val name = "Выход"
    override fun toString(): String {
        return this.name
    }
}
object CreateArchive: DataContainer {
    override val name = "Создать архив"
    override fun toString(): String {
        return this.name
    }
}

object CreateNote: DataContainer {
    override val name = "Создать заметку"
    override fun toString(): String {
        return this.name
    }
}