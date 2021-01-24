import { Exam } from "./exam.model"

export class PaymentTraining {
    paymentMode: string
    paymentDate: Date
    amount: number
    userId: number
    exam: Exam
    expMonth: string
    expYear: number
    cardNum: string
    cvv: number
}