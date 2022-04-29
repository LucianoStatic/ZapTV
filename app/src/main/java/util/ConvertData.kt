package util

class ConvertData {
    companion object{
        fun toDate(date: String?): String {
            val month =
                "Janeiro|Fevereiro|Março|Abril|Maio|Junho|Julho|Agosto|Setembro|Outubro|Novembro|Dezembro"
            val arrayMonth = month.split('|')
            val arrDate = date!!.split('-')
            return arrDate[2] + " " + arrayMonth[arrDate[1].toInt() - 1] + " " + arrDate[0]
        }
    }

}
