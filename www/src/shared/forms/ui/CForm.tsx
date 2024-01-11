'use client'

import {forwardRef, PropsWithChildren, useImperativeHandle } from "react";
import {FieldValues, Form, FormProvider, SubmitHandler, useForm} from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';


interface IFormProps extends PropsWithChildren {
  action: (form: FormData) => void
  onSubmit?: SubmitHandler<FieldValues>
  onError?:  ({ response, error, }: {
    response: Response;
    error?: undefined;
  } | {
    response?: undefined;
    error: unknown;
  }) => void;
  schema?: Parameters<typeof yupResolver>[0]
}

const CForm = forwardRef<ReturnType<typeof useForm>,IFormProps>(({ children, action, onSubmit, onError, schema }, ref) => {


  const methods = useForm({
    resolver: !!schema ? yupResolver(schema) : undefined,
  })
  const { handleSubmit } = methods

  useImperativeHandle(ref, () => methods, [methods])
  return (
    <FormProvider {...methods}>
      <Form action={action} onSubmit={onSubmit} onError={onError}>
        {children}
      </Form>
    </FormProvider>
  )
})

CForm.displayName = "CForm"

export default CForm
