'use client'

import {forwardRef, PropsWithChildren, useImperativeHandle, useMemo} from "react";
import {FieldValues, Form, FormProvider, SubmitErrorHandler, SubmitHandler, useForm} from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';


interface IFormProps extends PropsWithChildren {
  action: (form: FormData) => void
  onSubmit?: SubmitHandler<FieldValues>
  onError?: SubmitErrorHandler<FieldValues>
  schema?: Parameters<typeof yupResolver>[0]
}

const CForm = forwardRef<ReturnType<typeof useForm>,IFormProps>(({ children, action, onSubmit, onError, schema }, ref) => {
  const methods = useForm({
    resolver: yupResolver(schema),
  })
  const { handleSubmit } = methods

  useImperativeHandle(ref, () => methods, [methods])

  const submit = useMemo(() => {
    if (!onSubmit) onSubmit = () => {}
    if (!onError) onError = () => {}

    return handleSubmit(onSubmit, onError)
  }, [onSubmit, onError, handleSubmit])

  return (
    <FormProvider {...methods}>
      <Form action={action} onSubmit={submit} >
        {children}
      </Form>
    </FormProvider>
  )
})

CForm.displayName = "Form"

export default CForm
