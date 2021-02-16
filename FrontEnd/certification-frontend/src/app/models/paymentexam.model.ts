import { Exam } from './exam.model'

export class PaymentExam {
    paymentMode: string
    paymentDate: Date
    amount: number
    userId: number
    exam:Exam
    expMonth: string
    expYear: number
    cardNumber: string
    cvv: number
    name: string
   
}